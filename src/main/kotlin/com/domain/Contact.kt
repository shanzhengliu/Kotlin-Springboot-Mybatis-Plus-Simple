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
@TableName("contact")
class Contact : Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    var id: Int? = null

    var name: String? = null

    var address: String? = null


    override fun toString(): String {
        return "Contact{" +
        "id=" + id +
        ", name=" + name +
        ", address=" + address +
        "}"
    }
}
