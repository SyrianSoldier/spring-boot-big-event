package com.syriansoldier.big_event.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ResultTest {
    @Test
    public void testSuccess(){
        Result<String> res = Result.success("token");

        assertSame("200", res.getCode());
        assertSame("token", res.getData());
        assertSame("操作成功", res.getMessage());
    }
}
