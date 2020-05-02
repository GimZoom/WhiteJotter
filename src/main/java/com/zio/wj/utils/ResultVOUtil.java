package com.zio.wj.utils;

import com.zio.wj.enums.ResultCode;
import com.zio.wj.vo.ResultVO;

public class ResultVOUtil {
    public static <T> ResultVO<T> success(T data) {
        return new ResultVO<>(ResultCode.SUCCESS, data);
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO fail() {
        return new ResultVO(ResultCode.COMMON_FAIL);
    }

    public static ResultVO fail(ResultCode resultCode) {
        return new ResultVO(resultCode);
    }
}
