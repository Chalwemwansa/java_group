(define (fetch mylist index)
  (if (= index 0)
      (car mylist)
      (fetch (cdr mylist) (- index 1))
  )
)
(define mylist '(1 2 3 4 5 6 7 8))
(display (fetch mylist 4))
(newline)
