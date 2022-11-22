package com.g3c1.aidboss.domain.seat.domain.repository

import com.g3c1.aidboss.domain.seat.domain.entity.Seat
import com.g3c1.aidboss.domain.store.domain.entity.Store
import org.springframework.data.repository.CrudRepository
import java.util.*

interface SeatRepository: CrudRepository<Seat,Long> {
    fun findSeatById(seatId: Long): Optional<Seat>
    fun findAllByStore(store: Store): List<Seat>
}