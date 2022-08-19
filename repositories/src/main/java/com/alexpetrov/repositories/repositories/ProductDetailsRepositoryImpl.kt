package com.alexpetrov.repositories.repositories

import com.alexpetrov.model.entities.local.productdetails.ProductDetails
import com.alexpetrov.model.entities.responce.productdetails.ResponseProductDetails
import com.alexpetrov.repositories.data_source.RemoteDataSource
import com.alexpetrov.repositories.local_data_source.LocalDataSource

class ProductDetailsRepositoryImpl(private val dataSource: RemoteDataSource,private val  localDataSource: LocalDataSource<ProductDetails>) :
    ProductDetailsRepository {

    override suspend fun getProductDetails(id: String): ProductDetails? {
        val listResponseProductDetails = dataSource.getProductDetails()
        val samsungGalaxyNote = mapToProductDetails(listResponseProductDetails)
        localDataSource.addData("111", samsungGalaxyNote)
        localDataSource.addData("3333", samsungGalaxyNote)

        return localDataSource.getData(id)
    }

    private fun mapToProductDetails(response: List<ResponseProductDetails>): ProductDetails {
        val responseProductDetails = response[0]
        return ProductDetails(
            id = responseProductDetails.id,
            images = responseProductDetails.images,
            isFavorites = responseProductDetails.isFavorites,
            title = responseProductDetails.title,
            rating = responseProductDetails.rating,
            CPU = responseProductDetails.CPU,
            camera = responseProductDetails.camera,
            ssd = responseProductDetails.ssd,
            sd = responseProductDetails.sd,
            color = responseProductDetails.color,
            capacity = responseProductDetails.capacity,
            price = responseProductDetails.price
        )
    }
}