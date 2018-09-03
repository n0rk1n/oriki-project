package cn.oriki.commons.response.entity;

import lombok.*;

/**
 * Response 响应实体
 *
 * @author oriki.wang
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseEntity {

    private String code;
    private String type;
    private Object message;

}
