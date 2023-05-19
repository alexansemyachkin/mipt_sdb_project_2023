insert into role (id, name)
values (1, 'ROLE_ADMIN'),
       (2, 'ROLE_EXAMINER'),
       (3, 'ROLE_STUDENT');

insert into "user" (id, email, name, password, role_id)
values (1, 'admin@mail.ru', 'admin', '$2a$12$I7kmiueHP2g/HwJ5yHp50eH29JsMQN3pdDjqa51tbWDyy04Jr5kGK', 1),
       (2, 'examiner@mail.ru', 'examiner', '$2a$12$HxLjtKw.E4V/0BLD1/DY5OK0ZOc0xfjptsVAJSGTwkXPWmDp8CThi', 2),
       (3, 'student@mail.ru', 'student', '$2a$12$DUOsYwRmkaEeW2iMqEtlHuX2z2ZEqIDQaSD7YHoaMqxmL6H20OX/W', 3);

insert into subject (id, name)
values (1, 'Введение в математический анализ'),
       (2, 'Многомерный анализ, интегралы и ряды'),
       (3, 'Основы комбинаторики и теории чисел'),
       (4, 'Аналитическая геометрия'),
       (5, 'Основы вероятности и теории меры'),
       (6, 'Алгоритмы и структуры данных');

insert into ticket (id, question, subject_id)
values (1, '1. Теорема Кантора о вложенных отрезках <br/> 2. Теоремы о среднем Ролля, Лагранжа, Коши', 1),
       (2, '1. Теорема об обратной функции <br/> 2. Формула Ньютона-Лейбница', 1),
       (3, '1. Формула Лейбница для n-й производной функции произведения функций. </br> 2.Теорема Кантора о равномерной непрерывности', 1),
       (4, '1. Критерий Коши существования предела фунциию. <br/> 2. Формула Тейлора с остаточным членом в форме Лагранжа', 1),
       (5, '1. Лемма Гейна-Бореля </br> 2. Критерий интегрируемости Дарбу', 1),
       (6, '1. Теоремы Шварца и Юнга о достаточных условиях равенства смешанных производных. </br> 2. Геометрический смысл градиента', 2),
       (7, '1. Преобразование Абеля </br> 2. Теорема Коши-Адамара', 2),
       (8, '1. Теорема Римана о перестановке </br> 2. Дифференцируемость композиции', 2),
       (9, '1. Радиус и круг сходимости </br> 2. Матрица Якоби', 2),
       (10, '1. Признак Абеля равномерной содимости рядов </br> 2. Алгебры и сигма-алгебры, борелевская сигма-алгебра', 2),
       (11, '1. Системы вычетов </br> 2. Малая теорема Ферма', 3),
       (12, '1. Расстояние Хэмминга </br> 2. Теорема Дирихле о диофантовых приближениях', 3),
       (13, '1. Конечные цепные дроби </br> 2. Рекуррентные соотношения для числителей и знаменателй подходящих дробей', 3),
       (14, '1. Алгебраические и трансцендентные числа </br> 2. Определение решетки и его определителя', 3),
       (15, '1. Тригонометрические суммы </br> 2. Деревья, 4 эквивалентных определения', 3),
       (16, '1. Скалярное произведение и его свойства </br> 2. Векторные и координатные формы уравнений прямой на плоскости и в пространстве', 4),
       (17, '1. Эллипс, гипербола и парабола, их свойства </br> 2. Цилиндрические и конические поверхности', 4),
       (18, '1. Афинные преобразования плоскости и их основные свойства </br> 2. Алгебраические операции с матрицами', 4),
       (19, '1. Определение детерминанта </br> 2. Прямолинейные образующие', 4),
       (20, '1. Свойства детерминанта </br> 2. Прямая как линия пересечения двух плоскостей', 5),
       (21, '1. Геометрические вероятности </br> 2. Меры на полукольцах', 5),
       (22, '1. Независимость собыйтий, виды и взаимосвязь </br> 2. Структура измеримых множеств', 5),
       (23, '1.  Неравенства Маркова и Чебышева </br> 2. Теорема Каратеодори', 5),
       (24, '1. Классическая мера Лебега на полукольце промежутков и ее сигма-аддитивность </br> 2. Множество Кантора и кривая Кантора', 5),
       (25, '1. Условная вероятность </br> 2. Сходимость по мере и почти всюду', 5),
       (26, '1. Квадратичные сортировки </br> 2. Бинарное дерево поиска', 6),
       (27, '1. Нахождение НОП с помощью динамического программирования </br> 2. Пираимидальная сортировка', 6),
       (28, '1. Сортировка слиянием без доп.памяти </br> 2. AVl-дерево', 6),
       (29, '1. Односвязные и двусвязные списки </br> 2. Нахождение НВП с помощью динамического программирования', 6),
       (30, '1. Splay-дерево </br> 2. Задача о рюкзаке', 6);
