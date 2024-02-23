package com.sql.demo.service;

import com.sql.demo.entity.ContactSequenceEntity;
import com.sql.demo.model.SequenceDTO;
import com.sql.demo.repository.SequenceRepository;
import com.sun.source.tree.BinaryTree;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.relational.core.sql.In;
import org.springframework.data.relational.core.sql.LockMode;
import org.springframework.data.relational.repository.Lock;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@EnableRetry
public class SequenceRepositoryImpl implements SequenceRepository {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @Override
    @Transactional
    @QueryHints(value = {
            @QueryHint(name = "javax.persistence.query.timeout", value = "10000")
    })
    @Retryable(retryFor = {Exception.class}, maxAttempts = 7, backoff = @Backoff(delay = 250, multiplier =2))
    public SequenceDTO getNextEntity() {

        String str = "select f from ContactSequenceEntity f " +
                "where sequence = " +
                "(select max(sequence) from ContactSequenceEntity)";

        String lockUpdate = "UPDATE [dbo].[contact_sequence_entity] WITH (ROWLOCK) SET [sequence]= (:seq + 1) where [sequence]= :seq";

        ContactSequenceEntity result = entityManager.createQuery(str, ContactSequenceEntity.class).getSingleResult();
        String update = "update ContactSequenceEntity  seq set seq.sequence= :nextSeq where seq.sequence= :lastSeq";
        Query query = entityManager.createQuery(update);
        query.setParameter("nextSeq", result.getSequence() + 1);
        query.setParameter("lastSeq", result.getSequence());
        int rows = query.executeUpdate();

        log.info("<><>  Rows updated :: {}  for sequence :: {}  next value :: {} <><>", rows, result.getSequence(), result.getSequence() + 1);
//        int result  = query.executeUpdate();
//        log.info("<><><>  result = {} ", result);
//        TypedQuery<ContactSequenceEntity> typedQuery = entityManager.createQuery(str, ContactSequenceEntity.class);
//        int reult = typedQuery.setLockMode(LockModeType.PESSIMISTIC_WRITE).executeUpdate();

        ContactSequenceEntity sequenceEntity = entityManager.createQuery(str, ContactSequenceEntity.class).getSingleResult();

        return SequenceDTO
                .builder()
                .sequence(sequenceEntity.getSequence())
                .build();
    }

}
