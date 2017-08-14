
class Constants {

    object HTTP {
        val BASE_URL = "http://services.hanselandpetal.com"
    }

    object DATABASE {

        val DB_NAME = "flowers"
        val DB_VERSION = 1
        val TABLE_NAME = "flower"

        val DROP_QUERY = "DROP TABLE IF EXIST " + TABLE_NAME

        val GET_FLOWERS_QUERY = "SELECT * FROM " + TABLE_NAME

        val PRODUCT_ID = "productId"
        val CATEGORY = "category"
        val PRICE = "price"
        val INSTRUCTIONS = "instructions"
        val NAME = "name"
        val PHOTO_URL = "photo_url"
        val PHOTO = "photo"


        val CREATE_TABLE_QUERY = "CREATE TABLE " + TABLE_NAME + "" +
                "(" + PRODUCT_ID + " INTEGER PRIMARY KEY not null," +
                CATEGORY + " TEXT not null," +
                PRICE + " TEXT not null," +
                INSTRUCTIONS + " TEXT not null," +
                NAME + " TEXT not null," +
                PHOTO_URL + " TEXT not null," +
                PHOTO + " blob not null)"
    }

    object REFERENCE {
        val FLOWER = Config.PACKAGE_NAME + "flower"
    }

    object Config {
        val PACKAGE_NAME = "org.dalol.retrofit2_restapidemo."
    }
}