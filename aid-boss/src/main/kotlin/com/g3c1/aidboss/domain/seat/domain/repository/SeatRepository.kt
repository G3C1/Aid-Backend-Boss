package com.g3c1.aidboss.domain.seat.domain.repository

import com.g3c1.aidboss.domain.seat.domain.entity.Seat
import org.springframework.data.repository.CrudRepository

interface SeatRepository: CrudRepository<Seat,Long> {
}