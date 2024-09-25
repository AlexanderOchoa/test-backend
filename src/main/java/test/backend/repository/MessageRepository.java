package test.backend.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import test.backend.entity.Message;
import test.backend.entity.MessageAndUser;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query(value = "select m from Message m where m.userIdFrom= :userId or m.userIdTo= :userId order by m.messageDate DESC")
    List<Message> findByUser(Long userId, Pageable pageable);

    @Query(value = "select count(*) as total from Message m where m.userIdFrom= :userId")
    Long countByUser(Long userId);

    @Query(value = "select u.name as user, count(*) as total, m.messageDate as messageDate " +
            "from Message m " +
            "inner join User u on m.userIdTo = u.id " +
            "where m.userIdFrom= :userId GROUP BY m.userIdTo, u.name, m.messageDate")
    List<MessageAndUser> findByUserTo(Long userId);
}
