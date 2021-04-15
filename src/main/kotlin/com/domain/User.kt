package com.domain

import com.baomidou.mybatisplus.annotation.TableName
import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import java.io.Serializable
/**
 * <p>
 * 
 * </p>
 *
 * @author sam
 * @since 2021-04-15
 */
@TableName("user")
class User : Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    var id: Int? = null

    var username: String? = null

    var password: String? = null

    var role: String? = null


    override fun toString(): String {
        return "User{" +
        "id=" + id +
        ", username=" + username +
        ", password=" + password +
        ", role=" + role +
        "}"
    }
}
