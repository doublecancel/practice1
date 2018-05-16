package test.handler;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by Administrator on 2018/1/16.
 */
@Converter(autoApply = true)
public class LocaldateTimeConverter implements AttributeConverter<LocalDateTime, Date>{
    @Override
    public Date convertToDatabaseColumn(LocalDateTime attribute) {
        return attribute == null ? null : Timestamp.valueOf(attribute);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Date dbData) {
        return LocalDateTime.ofInstant(dbData.toInstant(), ZoneId.systemDefault());
    }

}
