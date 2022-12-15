package com.g3c1.aidboss.domain.seat.service.impl

import com.g3c1.aidboss.domain.seat.presentaion.data.dto.CreateSeatDto
import com.g3c1.aidboss.domain.seat.service.SeatService
import com.g3c1.aidboss.domain.seat.utils.SeatConverter
import com.g3c1.aidboss.domain.seat.utils.SeatUtils
import com.g3c1.aidboss.domain.seat.utils.SeatValidator
import com.g3c1.aidboss.domain.store.domain.entity.Store
import com.g3c1.aidboss.domain.user.domain.entity.User
import org.springframework.data.jpa.repository.Lock
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.LockModeType

@Service
class SeatServiceImpl(
    private val seatUtils: SeatUtils,
    private val seatValidator: SeatValidator,
    private val seatConverter: SeatConverter
): SeatService {
    @Transactional(rollbackFor = [Exception::class])
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    override fun createSeat(dto: CreateSeatDto) {
        seatConverter.toEntity(dto,Store(0,"","","",User("","","")))
            .let { seatUtils.save(it)}
    }

    @Transactional(rollbackFor = [Exception::class])
    override fun patchDisableUsingSeat(seatId: Long) =
        seatUtils.findSeatById(seatId)
            .let {seatValidator.checkIsNotUsed(it)}
            .let { it.enabled = true }
}