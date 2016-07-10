package javatar.model.report;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import javatar.model.FormData;
import javatar.web.SessionData;

import java.time.LocalDateTime;

public class PartForReportModule {

    public String carBrand;
    public String carModel;
    public String carEngine;
    public String partBrand;
    public String partId;
    public String partName;
    public String allegroLink;
    public String userName;
    public String userId;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public LocalDateTime dateTime;

    public PartSearchSource source;


    public PartForReportModule(FormData formData, SessionData sessionData, LocalDateTime dateTime,PartSearchSource source) {
        this.carBrand = formData.getCarBrand();
        this.carModel = formData.getCarModel();
        this.carEngine = formData.getCarEngine();
        this.partBrand = formData.getPartBrand();
        this.partId = formData.getPartId();
        this.partName = formData.getPartName();
        this.allegroLink = formData.getAllegroLink();
        this.userName = sessionData.getUserData();
        this.userId = String.valueOf(sessionData.getUserId());
        this.dateTime = dateTime;
        this.source = source;
    }

    @Override
    public String toString() {
        return "PartForReportModule{" +
                "carBrand='" + carBrand + '\'' +
                ", carModel='" + carModel + '\'' +
                ", carEngine='" + carEngine + '\'' +
                ", partBrand='" + partBrand + '\'' +
                ", partId='" + partId + '\'' +
                ", partName='" + partName + '\'' +
                ", allegroLink='" + allegroLink + '\'' +
                ", userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", dateTime=" + dateTime +
                ", source=" + source +
                '}';
    }

}
