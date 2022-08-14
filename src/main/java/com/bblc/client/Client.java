package com.bblc.client;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.bblc.category.Category;

import io.quarkus.hibernate.orm.panache.PanacheEntity;


@Entity
public class Client extends PanacheEntity{

    @Size(min = 5, message = "Nome muito curto")
    @Size(max = 100, message = "Nome muito longo")
    @NotBlank(message = "Nome não pode estar em branco")
    @NotNull
    @Column(nullable = false)
    private String completeName;
    
    @NotNull(message = "Idade não pode estar em branco")
    @Min(value = 18, message = "Cadastro de menor de 18 anos não permitido")
    @Column(nullable = false)
    private Integer age ;
    
    @NotBlank
    @NotNull
    @Column(nullable = false)
    @Pattern(regexp = "^[A-Z]{2}[\\d]{9}$", message = "Não é um VAT Number válido. Deve seguir o padrão XX999999999.")
    private String vatNumber;
    
    @NotBlank(message = "E-mail não pode estar em branco")
    @NotNull
    @Email(message = "Formato de e-mail inválido")
    @Column(nullable = false)
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    public Client() {
    }

    public Client(
        String completeName, Integer age, String vatNumber, String email) {
        this.completeName = completeName;
        this.age = age;
        this.vatNumber = vatNumber;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getCompleteName() {
        return completeName;
    }

    public Integer getAge() {
        return age;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public String getEmail() {
        return email;
    }

    public Client setId(long id) {
        this.id = id;
        return this;
    }

    public Client setCompleteName(String completeName) {
        this.completeName = completeName;
        return this;
    }
    
    public Client setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Client setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
        return this;
    }

    public Client setEmail(String email) {
        this.email = email;
        return this;
    }
    
    


}
