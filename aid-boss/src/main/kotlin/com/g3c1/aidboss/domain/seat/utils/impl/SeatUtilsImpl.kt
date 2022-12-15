package com.g3c1.aidboss.domain.seat.utils.impl

import com.g3c1.aidboss.domain.seat.domain.entity.Seat
import com.g3c1.aidboss.domain.seat.domain.repository.SeatRepository
import com.g3c1.aidboss.domain.seat.exception.SeatNotFoundException
import com.g3c1.aidboss.domain.seat.utils.SeatUtils
import com.g3c1.aidboss.domain.store.utils.StoreUtils
import org.springframework.stereotype.Component

@Component
class SeatUtilsImpl(
    private val seatRepository: SeatRepository,
    private val storeUtils: StoreUtils
): SeatUtils {
    override fun findSeatById(seatId: Long): Seat =
        seatRepository.findSeatById(seatId).orElseThrow { SeatNotFoundException() }
    override fun save(seat: Seat) {
        seatRepository.save(seat)
    }
    override fun findSeatByStoreId(serialNumber: Long): List<Seat> =
        storeUtils.findStoreBySerialNumber(serialNumber)
            .let { seatRepository.findAllByStore(it) }


}