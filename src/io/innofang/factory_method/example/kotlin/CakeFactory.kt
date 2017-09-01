package io.innofang.factory_method.example.kotlin


/**
 * Created by Inno Fang on 2017/9/1.
 */
class CakeFactory : Factory() {

    override fun <T : Cake> createProduct(clz: Class<T>): T? {
        var cake: Cake? = null
        try {
            cake = Class.forName(clz.name).newInstance() as Cake
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return cake as T?
    }
}