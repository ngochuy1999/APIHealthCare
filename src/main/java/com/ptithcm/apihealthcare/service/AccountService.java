package com.ptithcm.apihealthcare.service;

import com.ptithcm.apihealthcare.dao.AccountDAO;
import com.ptithcm.apihealthcare.email.EmailSender;
import com.ptithcm.apihealthcare.entities.Account;
import com.ptithcm.apihealthcare.entities.Doctor;
import com.ptithcm.apihealthcare.entities.Patient;
import com.ptithcm.apihealthcare.model.reponse.ObjectResponse;
import com.ptithcm.apihealthcare.model.request.AccountParam;
import com.ptithcm.apihealthcare.model.request.ChangePassParam;
import com.ptithcm.apihealthcare.model.request.EditProfileParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountService {
    @Autowired
    private AccountDAO accountDAO;

    private final EmailSender emailSender;

    public AccountService(EmailSender emailSender) {
        this.emailSender = emailSender;
    }


    public Account getAccount(int accId){
        return accountDAO.getAccount(accId);
    }

    public Patient getUser(int accId){
        return accountDAO.getUser(accId);
    }

    public Doctor getDoctor(int accId){
        return accountDAO.getDoctor(accId);
    }

    public List<Account> getAllAccounts(){
        return accountDAO.getAllAccounts();
    }

    public ResponseEntity<?> loginUser(String email, String password) {
        if(!accountDAO.checkEmail(email)){
            return ResponseEntity.ok( new ObjectResponse("0","Sai tài khoản hoặc mật khẩu",false,null));
        }

        Account accountEx = accountDAO.findByEmail(email);

        if (!password.equals(accountEx.getPassword())||accountEx.getRole().getRoleId() != 3 ) {
            return ResponseEntity.ok( new ObjectResponse("0","Sai tài khoản hoặc mật khẩu",false,null));
        } else {
            if(accountEx.getIsAccuracy() == 1) return ResponseEntity.ok(new ObjectResponse("1","Đăng nhập thành công",true,accountEx));
            else return ResponseEntity.ok(new ObjectResponse("0","Tài khoản chưa được kích hoạt, vui lòng kích hoạt  ở email xác thực",false,null));
        }
    }

    public ResponseEntity<?> loginAdmin(String email, String password) {
        if(!accountDAO.checkEmail(email)){
            return ResponseEntity.ok( new ObjectResponse("0","Sai tài khoản hoặc mật khẩu",false,null));
        }

        Account accountEx = accountDAO.findByEmail(email);

        if (password.equals(accountEx.getPassword()) && accountEx.getRole().getRoleId() != 3 ) {
            if(accountEx.getIsAccuracy() == 1) return ResponseEntity.ok(new ObjectResponse("1","Đăng nhập thành công",true,accountEx));
            else return ResponseEntity.ok(new ObjectResponse("0","Tài khoản chưa được kích hoạt, vui lòng kích hoạt  ở email xác thực",false,null));
        } else {
            return ResponseEntity.ok( new ObjectResponse("0","Sai tài khoản hoặc mật khẩu",false,null));
        }
    }

    public ResponseEntity<?> signup(AccountParam accountParam){

        if(accountDAO.checkEmail(accountParam.getEmail())){
            return ResponseEntity.ok(new ObjectResponse("0","Email đã được đăng kí",false,null));
        }
        Account result = accountDAO.createUser(accountParam);
        if(result != null){
            String link = "http://localhost:8080/api/confirmAcc?email="+ accountParam.getEmail();
            emailSender.send(
                    accountParam.getEmail(),
                    buildEmail(accountParam.getUserName(), link));
            return ResponseEntity.ok(new ObjectResponse("1","Đăng ký thành công",true,result));
        }else return ResponseEntity.ok(new ObjectResponse("0","Đăng ký không thành công",false,null));
    }

    private String buildEmail(String name, String link) {
        return "<div style=\"font-family:Helvetica,Arial,sans-serif;font-size:16px;margin:0;color:#0b0c0c\">\n" +
                "\n" +
                "<span style=\"display:none;font-size:1px;color:#fff;max-height:0\"></span>\n" +
                "\n" +
                "  <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;min-width:100%;width:100%!important\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"100%\" height=\"53\" bgcolor=\"#0b0c0c\">\n" +
                "        \n" +
                "        <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;max-width:580px\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">\n" +
                "          <tbody><tr>\n" +
                "            <td width=\"70\" bgcolor=\"#0b0c0c\" valign=\"middle\">\n" +
                "                <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td style=\"padding-left:10px\">\n" +
                "                  \n" +
                "                    </td>\n" +
                "                    <td style=\"font-size:28px;line-height:1.315789474;Margin-top:4px;padding-left:10px\">\n" +
                "                      <span style=\"font-family:Helvetica,Arial,sans-serif;font-weight:700;color:#ffffff;text-decoration:none;vertical-align:top;display:inline-block\">Confirm your email</span>\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "              </a>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"10\" height=\"10\" valign=\"middle\"></td>\n" +
                "      <td>\n" +
                "        \n" +
                "                <table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td bgcolor=\"#1D70B8\" width=\"100%\" height=\"10\"></td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\" height=\"10\"></td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "\n" +
                "\n" +
                "\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "      <td style=\"font-family:Helvetica,Arial,sans-serif;font-size:19px;line-height:1.315789474;max-width:560px\">\n" +
                "        \n" +
                "            <p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">Hi " + name + ",</p><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> Thank you for registering. Please click on the below link to activate your account: </p><blockquote style=\"Margin:0 0 20px 0;border-left:10px solid #b1b4b6;padding:15px 0 0.1px 15px;font-size:19px;line-height:25px\"><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> <a href=\"" + link + "\">Activate Now</a> </p></blockquote>\n Link will expire in 15 minutes. <p>See you soon</p>" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "  </tbody></table><div class=\"yj6qo\"></div><div class=\"adL\">\n" +
                "\n" +
                "</div></div>";
    }

    public ResponseEntity<?> changeInfo(EditProfileParam profileParam){
        return accountDAO.updateUser(profileParam);
    }
    public ResponseEntity<?> changeFCMToken(int id, String token){
        return accountDAO.updateFCMToken(id,token);
    }

    public ResponseEntity<?> changePassword(ChangePassParam changePassParam){
        return accountDAO.changePassword(changePassParam.getUserid(),changePassParam.getOldpass(),changePassParam.getNewpassword());
    }

    public ResponseEntity<?> updateAvatar(String url, int id){
        return accountDAO.updateAvatar(url,id);
    }

    public ResponseEntity<?> updateCover(String url, int id){
        return accountDAO.updateCover(url,id);
    }

    public List<Doctor> listFavDoc(int id){
        return accountDAO.listFavoriteDoctor(id);
    }

    public boolean confirm(String email){
        return accountDAO.confirm(email);
    }

}

