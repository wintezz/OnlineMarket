package com.alexpetrov.model.entities.local.productdetails

class ListProductDetails {
    val mapProductDetails = mutableMapOf(
        "222" to ProductDetails(
            id = "222",
            images = listOf(
                "https://items.s1.citilink.ru/1490110_v01_b.jpg",
                "https://items.s1.citilink.ru/1490110_v02_b.jpg",
                "https://items.s1.citilink.ru/1490110_v05_b.jpg"
            ),
            isFavorites = true,
            title = "Xiaomi Mi 10 Pro",
            rating = 4.5,
            CPU = "Snapdragon 732G",
            camera = "108 MP, 8 MP, 2 MP",
            ssd = "8 gb",
            sd = "128",
            capacity = listOf("128 gb", "256 gb"),
            color = listOf("#FF231B55", "#FF2E0791"),
            price = 400,
        ),
        "4444" to ProductDetails(
            id = "4444",
            images = listOf(
                "https://motorolaru.vtexassets.com/arquivos/ids/155460-800-800?width=800&height=800&aspect=true",
                "https://motorolaru.vtexassets.com/arquivos/ids/155461-800-800?width=800&height=800&aspect=true",
                "https://motorolaru.vtexassets.com/arquivos/ids/155463-800-800?width=800&height=800&aspect=true"
            ),
            isFavorites = true,
            title = "Motorola One Edge",
            rating = 3.4,
            CPU = "Snapdragon 865",
            camera = "108 MP",
            ssd = "12 gb",
            sd = "256 gb",
            capacity = listOf("256 gb", "512 gb"),
            color = listOf("#FF231B55", "#FF916C07"),
            price = 400,
        )
    )
}

