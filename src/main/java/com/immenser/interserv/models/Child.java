package com.immenser.interserv.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "child")
public class Child extends Person {

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "children")
    List<Parent> parents;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "child")
    private List<ChildPeriod> tickets;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "child")
    List<Inventory> inventory;

    private String image;

    @Transient
    @JsonSerialize
    @JsonDeserialize
    String base64img;

    @PostLoad
    void getBytesFromImage() {
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(image));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", byteArrayOutputStream);
            byte[] bytes = byteArrayOutputStream.toByteArray();
            base64img = Base64.getEncoder().encodeToString(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}