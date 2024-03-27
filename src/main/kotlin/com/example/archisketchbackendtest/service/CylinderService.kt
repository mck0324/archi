package com.example.archisketchbackendtest.service

import com.example.archisketchbackendtest.dto.CylinderResponse
import com.example.archisketchbackendtest.dto.EditorAsset
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Mono

@Service
class CylinderService(
    private val webClient: WebClient.Builder
) {

    fun fetchAndFilterData(): Mono<CylinderResponse> {
        return webClient.build().get()
            .uri("https://api.archisketch.com/v1/public/product/YB0Njg-02923BC5C1A84C59")
            .retrieve()
            .bodyToMono(Map::class.java)
            .map { response ->
                val productInfo = response["product"] as? Map<String, Any?>
                val editorAssetInfo = productInfo?.get("editorAsset") as? Map<String, Any?>
                CylinderResponse(
                    name = productInfo?.get("name") as? String,
                    editorAsset = editorAssetInfo?.let {
                        EditorAsset(
                            twoD = it["twoD"] as? String,
                            threeD = it["threeD"] as? String,
                            dxfUrl = it["dxfUrl"] as? String,
                            decimate = it["decimate"] as? String
                        )
                    }
                )
            }

    }
}