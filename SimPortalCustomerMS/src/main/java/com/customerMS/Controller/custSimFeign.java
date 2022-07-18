package com.customerMS.Controller;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="SimMS", url="http://localhost:7300/")
public interface custSimFeign {

}
