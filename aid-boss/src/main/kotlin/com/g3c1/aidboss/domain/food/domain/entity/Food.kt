package com.g3c1.aidboss.domain.food.domain.entity

import com.g3c1.aidboss.domain.category.domain.entity.Category
import com.g3c1.aidboss.domain.food.presentaion.data.dto.UpdateFoodDto
import com.g3c1.temiuser.global.entity.BaseIdEntity
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
data class Food(
    @Column(nullable = false)
    var name: String,
    @Column(nullable = false)
    var img: String,
    @Column(nullable = false)
    var description: String,
    @Column(nullable = false)
    var price: Long,
    @Column(nullable = false)
    var servings: Long,
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(nullable = false)
    var category: Category
):BaseIdEntity(){
    fun updateFood(dto: UpdateFoodDto,category: Category){
        this.name = dto.foodName
        this.img = dto.foodImg
        this.description = dto.foodDescription
        this.price = dto.price
        this.servings = dto.servings
        this.category = category
    }
}
