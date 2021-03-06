package me.syari.ss.core.persistentData.customType

import me.syari.ss.core.item.CustomItemStack
import org.bukkit.persistence.PersistentDataAdapterContext
import org.bukkit.persistence.PersistentDataType

object PersistentDataTypeCustomItemStack : PersistentDataType<String, CustomItemStack> {
    override fun getPrimitiveType(): Class<String> {
        return String::class.java
    }

    override fun getComplexType(): Class<CustomItemStack> {
        return CustomItemStack::class.java
    }

    override fun toPrimitive(complex: CustomItemStack, context: PersistentDataAdapterContext): String {
        return complex.toJson()
    }

    override fun fromPrimitive(primitive: String, context: PersistentDataAdapterContext): CustomItemStack {
        return CustomItemStack.fromJson(primitive)
    }
}