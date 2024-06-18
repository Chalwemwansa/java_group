(define (mylength mylist)
  (if (null? mylist)
    0
    (+ (mylength (cdr mylist)) 1)
    )
  )
(display (mylength (list 5 6 3 8 3 1 10)))
(newline)
