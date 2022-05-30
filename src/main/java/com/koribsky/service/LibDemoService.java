package com.koribsky.service;
;
import com.koribsky.domain.NewPoint;
import com.koribsky.repository.NewPointRepository;


import lombok.RequiredArgsConstructor;


import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;



import javax.transaction.Transactional;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LibDemoService {
    private final NewPointService pointService;
    private final NewPointRepository pointRepository;

    public void pointDemo()
    {
        byte[] arr = {1, 2, 3};
////        String byteArrayStr= new String(Base64.encodeBase64(test));
////
////       String s = javax.xml.bind.DatatypeConverter.printHexBinary(test);
////       String finger_buffer = Base64.encodeBase64String(test);
////        Decode String into Byte Array. decodedString is my bytearray[]
////        byte [] decodedString = Base64.decodeBase64(byteArrayStr);
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            s += arr[i] + " ";
        }
        String newS = "";
        for (int i = 0; i < s.length() -1; i++) {
            newS += s.charAt(i);
        }
        NewPoint point = NewPoint.builder().description("ok1").photo(newS).x(12).y(34).petName("Myrzik").petColor("black").petContact("89255697747").status("lost").build();
       // pointService.insert(point);






//        String inputString = "prologistic.com.ua";
//        // преобразуем нашу строку в массив байт
//        byte[] byteArray = inputString.getBytes();
//
//


     //   pointService.insert(point);
        System.out.println("======Все точки======");
        for (NewPoint p : pointService.getAll()) {

            System.out.println(p);
        }

        System.out.println("======================\n");
    }
}
