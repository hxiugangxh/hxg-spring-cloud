package com.hxg.simpledemo.swagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/swagger")
public class SwaggerController {

    @GetMapping("/{id:\\d+}")
    @ResponseBody
    @ApiOperation(value = "方法描述信息", notes = "头顶描述信息;<br />换行测试;")
    public SwaggerBean swaggerBean(@RequestParam(value = "id", required = true) Integer id) {

        SwaggerBean swaggerBean = new SwaggerBean();

        swaggerBean.setId(id);
        swaggerBean.setName("张三");
        swaggerBean.setAge(13);

        return swaggerBean;
    }

    @GetMapping("/getSwaggerByParams")
    @ApiOperation("通过参数获取SwaggerBean")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String",
                    name = "name", value = "姓名", required = true),
            @ApiImplicitParam(paramType = "body", dataType = "SwaggerBean",
                    name = "swaggerBean", value = "载体", required = true)
    })
    public SwaggerBean getSwaggerByParams(@RequestParam("name") String name,
                                          @RequestBody SwaggerBean swaggerBean) {
        SwaggerBean swaggerBean1 = new SwaggerBean();

        swaggerBean1.setId(1);
        swaggerBean1.setName("张三");
        swaggerBean1.setAge(13);

        return swaggerBean1;
    }
}
