package practice.email.parser

/**
 * Created by Pavel on 30.03.2016.
 */
object TestContents {
    val yam_tb_eng_rus = Content(
            """Тут находится a little mix from different languages.
""".replace("\n", "\r\n"), 
            null, null
    )

    val gmailMariya = Content(
            """Привет.

Я сделал вторую задачу, все в репозитории, посмотри, пожалуйста.
Подойдет ли такой вариант запуска gradle? (то что запуск задачи run и
передача числа происходят не вместе).

Id задачи указан не во всех коммитах (поздно вспомнил), но там они все
относятся ко второй задаче.
""".replace("\n", "\r\n"),
            null, 
            """-- 
Жук Павел.
""".replace("\n", "\r\n")
    )

    val ONE_gmail_tb_email_parser_task2_5_quotes = Content(
            """Привет,

В принципе, я более-менее живая и в офисе. Если не напишу до 15-00, 
встречаемся в 17-00 в офисе.

Скажи девочкам на ресепшене, что ты ко мне на практику, они либо 
пропустят, либо позовут меня. Я сижу в 508 (кабинет прямо напротив 
лифтовой площадки).
""".replace("\n", "\r\n"),
            Content(
                    """On 03/02/2016 12:10 AM, Павел Жук wrote:
 Почта с телефона доступна почти всегда, желательно где-то до 15:00 -
 15:30 меня предупредить. Если завтра не придет письма, считать что
 встреча состоится?
 Желаю поправиться.

 1 марта 2016 г., 19:15 пользователь Mariya Davydova
 <mariya.davydova@jetbrains.com> написал:
> Паша,
>
> Я приболела. Я очень надеюсь, что завтра смогу выйти, но не уверена. Как часто ты читаешь почту? Иными словами, когда крайний срок, чтобы предупредить тебя, если я все-таки разболеюсь?
>
> Sent from my iPad
>
>> On Mar 1, 2016, at 13:35, Павел Жук <ppzhuk@gmail.com> wrote:
>>
>> Нотификации получил, сегодня вечером займусь исправлением.
>>
>> 29 февраля 2016 г., 17:56 пользователь Mariya Davydova
>> <mariya.davydova@jetbrains.com> написал:
>>> Привет,
>>>
>>> Сделала глобальное ревью на весь код, оставила кучу комментов (если я
>>> правильно понимаю гитхаб, он уже должен забросать тебя нотификациями на эту
>>> тему). Если нотификаций вдруг нет, то просто почитай коммиты, комментарии
>>> аттачатся именно к ним.
>>>
>>> В целом хорошо, но много мелочей, на которые стоит обратить внимание. Мне бы
>>> хотелось, чтобы ты пофиксил указанные замечания.
>>>
>>>> On 02/27/2016 03:29 AM, Павел Жук wrote:
>>>>
>>>> Привет.
>>>>
>>>> Я сделал вторую задачу, все в репозитории, посмотри, пожалуйста.
>>>> Подойдет ли такой вариант запуска gradle? (то что запуск задачи run и
>>>> передача числа происходят не вместе).
>>>>
>>>> Id задачи указан не во всех коммитах (поздно вспомнил), но там они все
>>>> относятся ко второй задаче.
>>>>
>>> --
>>> Best regards,
>>> Mariya Davydova
>>> Software Developer
>>> JetBrains
>>> http://www.jetbrains.com
>>> The Drive to Develop
>>>
>>
>>
>> --
>> Жук Павел.

""".replace("\n", "\r\n"), 
                    null, null
            ),
"""-- 
Best regards,
Mariya Davydova
Software Developer
JetBrains
http://www.jetbrains.com
The Drive to Develop

"""
    )

    val DEEP_gmail_tb_email_parser_task2_5_quotes = Content("", null, null)
    
}