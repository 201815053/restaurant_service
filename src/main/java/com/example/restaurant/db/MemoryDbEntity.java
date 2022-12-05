package com.example.restaurant.db;

//data, db 공통적인 사항을 정리

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemoryDbEntity {

    protected Integer index;

}
