package com.esme.spring.faircorp;

import com.esme.spring.faircorp.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomDao extends JpaRepository<Room,Long> {
}
