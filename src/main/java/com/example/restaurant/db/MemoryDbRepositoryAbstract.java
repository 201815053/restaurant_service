package com.example.restaurant.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

//모든 데이터베이스를 상속받은 애들은 MemoryDbEntity를 상속받을 것임
//MemoryDbEntity를 상속받은 제네릭 타입이 필요
abstract public class MemoryDbRepositoryAbstract<T extends MemoryDbEntity> implements MemoryDbRepositoryIfs<T> {

    private  final List<T> db = new ArrayList<>();
    private int index = 0;

    @Override
    public Optional<T> findById(int index) {
        return db.stream().filter(it -> it.getIndex() == index).findFirst();
        //filter: db.stream()에 들어 있는 리스트 타입에 대한 부분
        //getIndex: MemoryDbEntity에 정의 되어있는 index
    }

    @Override
    public T save(T entity) {

        var optionalEntity = db.stream().filter(it -> it.getIndex() == entity.getIndex()).findFirst();

        if(optionalEntity.isEmpty()){
            //db에 이미 데이터가 있는 경우
            index++;
            entity.setIndex(index);
            db.add(entity);
            return entity;

        }else {
            //db에 이미 데이터가 없는 경우
            var preIndex = optionalEntity.get().getIndex();
            entity.setIndex(preIndex);

            deleteById(preIndex);
            db.add(entity);
            return entity;

        }

    }

    @Override
    public void deleteById(int index) {
        //데이터베이스에서 인덱스를 삭제
        var optionalEntity = db.stream().filter(it -> it.getIndex() == index).findFirst();
        if (optionalEntity.isPresent()){
            //해당오브젝트와 동일한 오브젝트를 지움
            db.remove(optionalEntity.get());
        }


    }

    @Override
    public List<T> findAll() {
        //db의 모든 내용을 리턴시킴
        return db;
    }


}
