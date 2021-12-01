package com.ptithcm.apihealthcare.dao;

import com.ptithcm.apihealthcare.entities.Account;
import com.ptithcm.apihealthcare.entities.Doctor;
import com.ptithcm.apihealthcare.entities.Patient;
import com.ptithcm.apihealthcare.entities.Role;
import com.ptithcm.apihealthcare.model.reponse.ObjectResponse;
import com.ptithcm.apihealthcare.model.request.AccountParam;
import com.ptithcm.apihealthcare.model.request.EditProfileParam;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

@Repository
public class AccountDAO {
    @Autowired
    private SessionFactory sessionFactory;


    public Patient getUser(int PID){
        Session session = sessionFactory.getCurrentSession();
        return (Patient) session.createQuery("FROM Patient p WHERE p.id = '"+PID+"'").uniqueResult();
    }

    public Doctor getDoctor(int PID){
        Session session = sessionFactory.getCurrentSession();
        return (Doctor) session.createQuery("FROM Doctor p WHERE p.doctorId = '"+PID+"'").uniqueResult();
    }

    public Account getAccount(int accId){
        Session session = sessionFactory.getCurrentSession();
        return (Account) session.createQuery("FROM Account a WHERE a.accountId = '"+accId+"'").uniqueResult();
    }

    public List<Account> getAllAccounts(){
        Session session = sessionFactory.getCurrentSession();
        return (List<Account>) session.createQuery("from "+Account.class.getName()).list();
    }

    public Boolean checkEmail(String email){
        Session session = sessionFactory.getCurrentSession();
        return (Long) session.createQuery("select count(*) from Account as a where a.email = '"+email+"'").uniqueResult() > 0;
    }

    public Account findByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        return  (Account) session.createQuery("FROM Account a WHERE a.email = '" + email + "'").uniqueResult();
    }

    public Account createUser(AccountParam accountParam) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        try {
            Role role = (Role) session.createQuery("FROM Role as r WHERE r.roleId = 3").uniqueResult();
            Account account = new Account();
            account.setRole(role);
            account.setEmail(accountParam.getEmail());
            account.setPassword(accountParam.getPassword());
            account.setUserName(accountParam.getUserName());
            account.setPhone(accountParam.getPhone());
            long millis=System.currentTimeMillis();   java.sql.Date date=new java.sql.Date(millis);
            account.setDateCreate(date);
            System.out.println(accountParam.getToken());
            account.setToken(accountParam.getToken());
            account.setIsAccuracy(0);
            account.setActive(1);
            session.save(account);
            t.commit();
            return account;
        } catch (Exception e) {
            t.rollback();
            System.out.println("Loi" + e);
        } finally {
            session.close();
        }
        return null;
    }

    public ResponseEntity<?> updateUser(EditProfileParam profileParam){
        System.out.println(profileParam.getBirthday());
        String date = convertFormat(profileParam.getBirthday(),"dd/MM/yyyy","yyyy-MM-dd");
        Date datenew = Date.valueOf(date);
        System.out.println(datenew);
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            String hql = "UPDATE Patient set name = :name , identityCard = : identity, " +
                    "gender = :gender, birthday = :birthday, address = :address " +
                    " WHERE userId = :id";
            Query query = session.createQuery(hql);
            query.setParameter("name", profileParam.getName());
            query.setParameter("identity", profileParam.getIdentityCard());
            query.setParameter("gender", profileParam.getGender());
            query.setParameter("birthday",datenew);
            query.setParameter("address", profileParam.getAddress());
            query.setParameter("id",profileParam.getUserid());
            int result = query.executeUpdate();
            t.commit();
            if(result==1) {
                Patient profile = getUser(profileParam.getUserid());
                return ResponseEntity.ok(new ObjectResponse("1","Cập nhật thông tin thành công",true, profile));
            }
            else  return ResponseEntity.ok(new ObjectResponse("0","Cập nhật thông tin không thành công",false,null));
        } catch (Exception e) {
            t.rollback();
            System.out.println(e);
        } finally {
            session.close();
        }
        return  ResponseEntity.ok(new ObjectResponse("0","Cập nhật thông tin không thành công",false,null));
    }

    public ResponseEntity<?> updateFCMToken(int id, String token){
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            String hql = "UPDATE Account set token = :token WHERE accountId = :id";
            Query query = session.createQuery(hql);
            query.setParameter("token", token);
            query.setParameter("id",id);
            int result = query.executeUpdate();
            t.commit();
            if(result==1) {
                return ResponseEntity.ok(new ObjectResponse("1","Cập nhật thông tin thành công",true, token));
            }
            else  return ResponseEntity.ok(new ObjectResponse("0","Cập nhật thông tin không thành công",false,null));
        } catch (Exception e) {
            t.rollback();
            System.out.println(e);
        } finally {
            session.close();
        }
        return  ResponseEntity.ok(new ObjectResponse("0","Cập nhật thông tin không thành công",false,null));
    }

    public ResponseEntity<?> changePassword(int id, String oldPassword, String newPassword) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            Account account = getAccount(id);
            if (oldPassword.equals(account.getPassword())) {
                String hql = "UPDATE Account set password = :password " +
                        " WHERE accountId = :id";
                Query query = session.createQuery(hql);
                query.setParameter("password", newPassword);
                query.setParameter("id", id);
                int result = query.executeUpdate();
                t.commit();
                if (result == 1) {
                    Account accountnew = getAccount(id);
                    return ResponseEntity.ok(new ObjectResponse("1","Đổi mật khẩu thành công",true,accountnew));
                }
                else return ResponseEntity.ok(new ObjectResponse("0","Đổi mật khẩu không thành công",false,null));
            } else return ResponseEntity.ok(new ObjectResponse("0","Mật khẩu cũ không đúng",false,null));
        } catch (Exception e) {
            t.rollback();
            System.out.println("Loi" + e);
        } finally {
            session.close();
        }
        return ResponseEntity.ok(new ObjectResponse("0","Đổi mật khẩu không thành công",false,null));
    }

    public Boolean confirm(String email){
        Session session = sessionFactory.getCurrentSession();
        Account accUpdate= (Account) session.createQuery("FROM Account as a WHERE a.email= '"+email+"'").uniqueResult();
        accUpdate.setIsAccuracy(1);
        session.update(accUpdate);
        return true;
    }

    public String convertFormat(String dateTime,String fromFormat,String toFormat){
        if (!dateTime.isEmpty()) {
            SimpleDateFormat fromFormatter = new SimpleDateFormat(fromFormat, new Locale("vi"));
            SimpleDateFormat toFormatter = new SimpleDateFormat(toFormat, new Locale("vi"));
            try {
                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(fromFormatter.parse(dateTime).getTime());
                return toFormatter.format(cal.getTime());
            } catch (ParseException e) {
            }
        }
        return "";
    }

}
