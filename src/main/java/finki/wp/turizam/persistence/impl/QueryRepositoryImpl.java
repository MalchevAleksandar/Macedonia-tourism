package finki.wp.turizam.persistence.impl;

import finki.wp.turizam.model.jpa.Tmesto;
import finki.wp.turizam.persistence.TmestoRepository;
import finki.wp.turizam.persistence.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;


@Repository
public class QueryRepositoryImpl implements QueryRepository {

  TmestoRepository mestoRepository;

  @Autowired
  public QueryRepositoryImpl(TmestoRepository bookRepository) {
    this.mestoRepository = bookRepository;
  }


  @Override
  public Iterable<Tmesto> findsite(){


   // PageRequest limit = new PageRequest(0,10);
    return mestoRepository.findAll();

      }

//  @Override
//  public Page<Tmesto> findAll(Pageable p){
//
//
//    return mestoRepository.findAll(p);
//
//  }

  @Override
  public Page<Tmesto> findMestaByCategoryPaged(Long categoryId, int page, int pageSize) {
    return mestoRepository.findAll(
      (book, cq, cb) -> cb.equal(book.join("category").get("id"), categoryId),
      new PageRequest(page, pageSize)
    );
  }

  @Override
  public Page<Tmesto> findPromotedBooks(int page, int pageSize) {
    return mestoRepository.findAll(
      (book, cq, cb) -> cb.equal(book.get("promoted"), true),
      new PageRequest(page, pageSize)
    );
  }
}
