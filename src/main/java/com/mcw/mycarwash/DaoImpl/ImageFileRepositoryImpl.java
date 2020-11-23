package com.mcw.mycarwash.DaoImpl;

import com.mcw.mycarwash.Dao.DBFile;
import com.mcw.mycarwash.Model.ImageFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class ImageFileRepositoryImpl implements DBFile {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate jdbcTemplateName;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcTemplateName = new NamedParameterJdbcTemplate(dataSource);
    }


    @Override
    public ImageFile getbyimgid(String clientId, String imgId) {
        String query = "SELECT * FROM image WHERE client_id = '" + clientId + "' AND image_id='"+imgId+"'";
        List<ImageFile> imageFiles = jdbcTemplate.query(query, new BeanPropertyRowMapper(ImageFile.class));
        ImageFile imageFile = new ImageFile();
        for (ImageFile entity : imageFiles) {
            imageFile = entity;
        }
        return imageFile;
    }
}
