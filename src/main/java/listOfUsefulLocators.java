public class listOfUsefulLocators {

    // Раздел "Вопросы о важном"
    ////div[@class='Home_FourPart__1uthg']


    // Первый элемент (вопрос) в блоке
    ////div[@id='accordion__heading-8']

    // 1 ШАГ (1 СТРАНИЦА "Для кого самокат") - https://qa-scooter.praktikum-services.ru/order  - <div class="Order_Header__BZXOb">Для кого самокат</div>

    // Кнопка "ЗАКАЗАТЬ" в header
    ////button[@class='Button_Button__ra12g']

    // Поле ввода "Имя"
    ////input[@placeholder='* Имя']

    // Поле ввода "Фамилия"
    ////input[@placeholder='* Фамилия']

    // Поле ввода "Адрес"
    //input[@placeholder='* Адрес: куда привезти заказ']

    // Блок с Селектом "Метро"
////input[@placeholder='* Станция метро']
    //document.querySelector("input[placeholder='* Станция метро']")

    // Поле ввода "Телефон"
////input[@placeholder='* Телефон: на него позвонит курьер']

    // Кнопка "Далее"
    ////button[@class='Button_Button__ra12g Button_Middle__1CSJM']


    // 2 ШАГ (2 СТРАНИЦА "про Аренду") - https://qa-scooter.praktikum-services.ru/order
//By.tagName(input [class = 'Order_Header__BZXOb' and text() = 'Про Аренду'])







    // Поле ввода с выпадающим списком "Когда привезти самокат"
    // input[placeholder='* Когда привезти самокат']

    // Поле "Срок Аренды" (Закрытое состояние, до клика)
//B//span[@class='Dropdown-arrow']


    // Цвет самоката (ничего не выбрано)
//input[@id='black']

    // Комментарий для курьера
////input[@placeholder='Комментарий для курьера']

    // Кнопка заказать
//button[@class='Button_Button__ra12g Button_Middle__1CSJM']



    //3 ШАГ (ПОДТВЕРЖДЕНИЕ) - <div class="Button_Button__ra12g Button_Middle__1CSJM">Хотите оформить заказ?<br><div class="Order_Text__2broi">&nbsp;</div></div><div class="Order_Buttons__1xGrp"><button class="Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i">Нет</button><button class="Button_Button__ra12g Button_Middle__1CSJM">Да</button></div></div>
//By.xpath(//div[class = 'Order_Modal__YZ-d3']

// кнопка ДА
    ////div[class='Order_Modal__YZ-d3']/button[class='Button_Button__ra12g Button_Middle__1CSJM']


    // Кнопка НЕТ
    //By.tagName(button[class = 'Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i' and text() = 'Нет'])

}



