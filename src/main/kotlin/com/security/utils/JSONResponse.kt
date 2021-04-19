package com.security.utils

import org.json.JSONObject
import java.util.HashMap
import javax.servlet.http.HttpServletResponse

object JSONResponse {

    fun responseJson(code:Int=200,response:HttpServletResponse?,data:Any)
    {
        val resultData: HashMap<String, Any> = HashMap()
        resultData.put("code",code.toString());
        resultData.put("msg", data);
        if (response != null) {
            response.contentType="application/json;charset=utf-8"
            response.status=code
            response.writer.print(JSONObject.valueToString(resultData))
        }

    }
}