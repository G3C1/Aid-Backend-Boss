package com.g3c1.aidboss.domain.seat.service.impl

import com.g3c1.aidboss.domain.seat.presentaion.data.dto.CreateSeatDto
import com.g3c1.aidboss.domain.seat.service.SeatServiceV2
import com.g3c1.aidboss.domain.seat.utils.SeatConverter
import com.g3c1.aidboss.domain.seat.utils.SeatUtils
import com.g3c1.aidboss.domain.store.utils.StoreUtlis
import org.springframework.data.jpa.repository.Lock
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.LockModeType

@Service
class SeatServiceV2Impl(
    private val seatConverter: SeatConverter,
    private val seatUtils: SeatUtils,
    private val storeUtils: StoreUtlis
): SeatServiceV2 {
    @Transactional(rollbackFor = [Exception::class])
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    override fun createSeat(createSeatDto: CreateSeatDto, serialNumber: Long) {
        seatConverter.toEntity(createSeatDto,storeUtils.findStoreBySerialNumber(serialNumber))
            .let(seatUtils::save)
    }
}