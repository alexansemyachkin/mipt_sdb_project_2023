insert into role (id, name)
values (1, 'ROLE_ADMIN'),
       (2, 'ROLE_EXAMINER'),
       (3, 'ROLE_STUDENT');

insert into subject (id, name, department)
values (1, 'Введение в математический анализ', 'Кафедра высшей математики'),
       (2, 'Многомерный анализ, интегралы и ряды', 'Кафедра высшей математики'),
       (3, 'Основы комбинаторики и теории чисел 1', 'Кафедра дискретной математики'),
       (4, 'Математическая логика и теория алгоритмов', 'Кафедра дискретной математики'),
       (5, 'Алгоритмы и структуры данных', 'Кафедра алгоритмов и технологий программирования'),
       (6, 'Аналитическая геометрия', 'Кафедра высшей математики'),
       (7, 'Основы вероятности и теории меры', 'Кафедра дискретной математики'),
       (8, 'Линейная алгебра', 'Кафедра высшей математики'),
       (9, 'Алгебра и геометрия', 'Кафедра высшей математики'),
       (10, 'Основы комбинаторики и теории чисел 2', 'Кафедра дискретной математики');

insert into ticket (id, question, subject_id)
values (1, 'Теорема Кантора о вложенных отрезках', 1),
       (2, 'Теоремы о среднем Ролля, Лагранжа, Коши', 1),
       (3, 'Теорема об инвариантности порядка линии на плоскости', 6),
       (4, 'Комбинаторные тождества (6шт.)', 3),
       (5, 'Свойства детерминанта', 6),
       (6, 'Теоремы Эйлера о о равенстве количеств неупорядоченных числа n на k или не беолее чем k слагаемых', 3),
       (7, 'Геометрический смысл градиента', 2),
       (8, 'Теоремы Шварца и Юнга о достаточных условиях равенства смешанных производных', 2),
       (9, 'Теорема Каратеодори', 7),
       (10, 'Теорема о сингулярном разложении', 8);