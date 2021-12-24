package com.ptithcm.apihealthcare.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "TestResultDetail")
@Entity
@Getter
@Setter
public class TestResultDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "fileUrl")
    private String fileUrl;

    @Column(name = "imageUrl")
    private String imageUrl;

    @ManyToOne(optional = false)
    @JoinColumn(name = "resultId")
    private TestResult testResult;

    @Column(name = "active", nullable = false)
    private Integer active;
}
