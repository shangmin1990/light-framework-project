package com.benjamin.project.dao.typehandler;

import com.benjamin.project.model.enums.ImageType;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by benjamin on 2017/7/18.
 */
@MappedTypes({ImageType.class})
public class CustomEnumTypeHandler<E extends Enum<E>> extends BaseTypeHandler<E> {

    private Class<E> type;

    public CustomEnumTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
    }
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Enum parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.name());
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String str = rs.getString(columnName);
        return getEnumValue(str);
    }

    private E getEnumValue(String str) {
        if (str == null || str.isEmpty()){
            return null;
        }
        E result = null;
        try {
            result = Enum.valueOf(type, str);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String str = rs.getString(columnIndex);
        return getEnumValue(str);
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String str = cs.getString(columnIndex);
        return getEnumValue(str);
    }

    public static void main(String[] args) {
        System.out.println(Enum.class.isAssignableFrom(Enum.class));
    }
}
