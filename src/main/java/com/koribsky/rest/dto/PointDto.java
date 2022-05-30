package com.koribsky.rest.dto;
import com.koribsky.domain.NewPoint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PointDto {
    private int id;
    private String description;
    //переделать в стринг, сплитнуть в байт на тут и на андроид
    private String photo;
    private double x;
    private double y;
    private String petName;
    private String petColor;
    private String petContact;
    private String status;
    public static PointDto toDto(NewPoint point)
    {
        return new PointDto(point.getId(), point.getDescription(), point.getPhoto(), point.getX(), point.getY(), point.getPetName(), point.getPetColor(), point.getPetContact(), point.getStatus());
    }
    public static NewPoint toDomainObject(PointDto pointDto){
        return new NewPoint(pointDto.getId(), pointDto.getDescription(), pointDto.getPhoto(), pointDto.getX(), pointDto.getY(), pointDto.getPetName(), pointDto.getPetColor(), pointDto.getPetContact(), pointDto.getStatus());
    }
}
