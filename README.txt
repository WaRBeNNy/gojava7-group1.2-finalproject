==============================================READ ME================================================
I. Описание задачи
II. Описание программы
III. Класс JsonSerializer
IV. Интерфейс JsonMapper и его реализации
V. Классы JsonWriter и JsonIndentedWriter

=====================================I. Описание задачи =============================================
Создать повторноиспользуемый сериализатор JSON соответсвующий аналогам.
- Должен уметь записывать объекты(Maps, Collections, Arrays, SimpleValue) в строки и Stream-ы.
- Поддержка аннотаций для:
   - Изменения имени свойства
   - Игнорирования свойства при сериализации
- Поддержка transient полей (transient int x ;):
   - По умолчанию игнорировать их
   - Если на него навешена аннотация JsonProperty – сериализровать.
- Поддержка как полей
  - По умолчанию все публичные поля
  - Приватные поля отмеченные аннотацией JsonProperty
  - В случае конфликта имен приоритет отдается той сущности, на которой есть аннотация
- Возможность вывода JSON как в компактном виде (без лишних пробелов, без ентеров), так и в удобочитаемом
виде (с отступами, разрывами строк, пробелами вокруг « : »)
- Запись null значений.

======================================II. Описание работы программы ==================================
Для использования сериализатора необходимо получить экземпляр класса JsonSerializer, вызвать у него метод
serialize. Результат работы метода можно сразу записать в переменную String, передав методу объект, который
необходимо привести к формату JSON. Есть возможность просто вызвать метод serialize, передав ему сериализуемый
объект и какой-то поток(Stream).
JsonSerializer определяет класс переданного объекта с помощью метода getMappera и передает искомый объект
соответсвующей реализации интерфейса JsonMapper.
Mapper записывает полученный объект в формат JSON, используя методы класса JsonWriter.
Проект имеет свои аннотации: @JsonProperty - определяет поле объекта, подлежащее сериализации в любом случае,
@JsonIgnore - определяет поле, не подлежащее сериализациию

=======================================III. Класс JsonSerializer ======================================
Данный класс содержит следующие поля:
- private static volatile JsonSerializer instance = new JsonSerializer(); - создает экземпляр класса
согласно паттерна Singleton
- public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8"); - поле для хранения кодировки
по умолчанию
- private boolean indent; - если true - сериализация с отступами, false - сплошной строкой
- Map<Class, JsonMapper> mappersCache = new HashMap<>(); - мапа, хранящая реализации JsonMapper.

Приватный конструктор JsonSerializer записывает в mappersCache реализации JsonMapper по ключу, соответсвующему
обрабатываемым ими классам.

Методы класса:
- public static JsonSerializer getInstance() - возвращает ссылку на экземпляр JsonSerializer.
- public boolean isIndent() - устанавливает значение поля indent
- public String serialize(Object obj) - возвращает строку, содержащую объект, приведенный к формату JSON
- public void serialize(Object obj, OutputStream stream) - принимает объект и stream, передает их дальше
вместе с кодировкой по умолчанию.
- public void serialize(Object obj, OutputStream stream, Charset charset) - принимает объект, stream и кодировку.
Создает OutputStreamWriter на основании stream и кодировки и передает его дальше вместе с объектом.
- public void serialize(Object obj, Writer writer) - принимает объект и writer. Проверяет значеиние поля
indent: если true - создает IndentedJsonWriter, если false - создает JsonWriter. Передает объект и определенный
JsonWriter дальше.
- protected void serialize(Object object, JsonWriter writer) - принимает объект и JsonWriter. Если объект null -
вызывает метод writeNull JsonWriter'a. В ином случае вызывает метод getMapper, у полученного mapper'a
вызывает метод write. В конце вызывает метод flush JsonWriter'a.
- protected JsonMapper getMapper(Class clazz) - получает класс, проверяет от какого ключа mappersCache наследуется
полученный класс - возвращает mapper по ключу. Если ни по одному ключу класс не подходит, возвращается ObjectMapper.

=========================================IV. Интерфейс JsonMapper и его реализации ======================
Интерфейс JsonMapper содержит в себе только один метод write, который получает объект и JsonWriter и приводит
объект к формату JSON.

StringMapper - вызывает метод writeString JsonWriter'a, передавая ему результат метода toString() полученного
объекта.
NumberMapper - приводит объект к типу Number и передает его методу writeNumber JsonWriter'a.
BooleanMapper - привеодит объект к типу Boolean и передает его методу writeBoolean JsonWriter'a.
ObjectMapper - вызывает метод writeObjectBegin JsonWriter'a. С помощью рефлексии получает поля объекта,
обрабатывает их аннотации и модификаторы согласно условия задачи и передает каждое поле, удовлетворяющее этим
условиям JsonSerializer'у вместе со значением поля writer полученного JsonWriter'a. После обработки всех
полей объекта, вызывается метод writeObjectEnd JsonWriter'a.
PrimitiveArrayMapper - вызывает метод writeArrayBegin JsonWriter'a, приводит полученный объект к массиву и
передает каждый его элемент методу serialize JsonSerializer'a. В конце вызывает метод writeArrayEnd JsonWriter'a.
ObjectArrayMapper - выполняет те же действия, что и PrimitiveArrayMapper.
CollectionMapper - делает то же, что и ArrayMapper, но приводит объект к коллекции и обрабатывает ее элементы.
MapMapper - делает то же, что и CollectionMapper, но перед сериализацией элементов мапы, передает ключ методу
writeString JsonWriter'a.

===========================================V. Класс JsonWriter и IndentedJsonWriter ========================
JsonWriter оболочка над Writer. Конструктор JsonWriter'a принимает Writer.
Методы JsonWriter:
- public Writer getWriter() - возвращает значение поля writer.
- public void writeObjectBegin() - вызывает метод write Writer'a и передает ему {.
- public void writeObjectEnd() - вызывает метод write Writer'a и передает ему }.
- public void writeArrayBegin() - вызывает метод write Writer'a и передает ему [.
- public void writeArrayEnd() - вызывает метод write Writer'a и передает ему ].
- public void writeString(String StringValue) - принимает строку и передает ее методу write Writer'a вместе с
кавычками с двух сторон.
- public void writeNumber(Number number) - принимает число, приводит его к строке и передает методу write Writer'a
- public void writeSeparator() - вызывает метод write Writer'a и передает ему ,
- public void writePropertySeparator() - вызывает метод write Writer'a и передает ему :
- public void writeBoolean(Boolean BooleanValue) - принимает булеан, приводит его к строке и передает методу
write Writer'a
- public void writeNull() - вызывает метод write Writer'a и передает ему null
- public void flush() - вызывает метод flush Writer'a

IndentedJsonWriter наследует класс JsonWriter и переопределяет его методы так, чтобы значения записывались с
отступами и переходами на новую строку.
Имеет поля:
private int indentSize  - определяет размер отступов
private int currentLevel - определяет текущий уровень вложенности
