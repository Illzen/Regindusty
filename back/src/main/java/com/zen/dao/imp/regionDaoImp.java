package com.zen.dao.imp;

import com.zen.dao.regionDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class regionDaoImp implements regionDao {

    private int adCode;

    private String name;

}
