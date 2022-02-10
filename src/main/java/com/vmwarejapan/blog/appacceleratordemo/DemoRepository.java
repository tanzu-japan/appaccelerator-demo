package com.vmwarejapan.blog.appacceleratordemo;

import org.springframework.data.repository.CrudRepository;

public interface DemoRepository extends CrudRepository<DemoEntity, Integer> {
}
