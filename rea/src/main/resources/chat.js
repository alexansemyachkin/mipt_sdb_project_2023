const socket = new SockJS('/ws'); // создаем соединение с сервером
const stompClient = Stomp.over(socket); // создаем клиент для обмена сообщениями

stompClient.connect({}, function (frame) { // подключаемся к брокеру сообщений
    stompClient.subscribe('/home/chat/messages', function (response) { // подписываемся на получение сообщений из конкретной комнаты
        const message = JSON.parse(response.body);
        showMessage(message); // вызываем функцию, которая выводит сообщение на страницу
    });
});

function sendMessage(chatId, senderId, recipientId, text) { // функция для отправки сообщения
    const message = {
        chatId: chatId,
        senderId: senderId,
        recipientId: recipientId,
        text: text
    };
    stompClient.send("/app/chat", {}, JSON.stringify(message)); // отправляем сообщение на сервер
}

function showMessage(message) { // функция для вывода сообщения на страницу
    // создаем HTML-элементы, содержащие текст сообщения
    const chatId = document.createElement('p');
    chatId.innerHTML = message.chatId;

    const senderId = document.createElement('p');
    senderId.innerHTML = message.senderId;

    const recipientId = document.createElement('p');
    recipientId.innerHTML = message.recipientId;

    const text = document.createElement('p');
    text.innerHTML = message.text;

    // добавляем элементы на страницу
    const messages = document.getElementById('messages');
    messages.appendChild(chatId);
    messages.appendChild(senderId);
    messages.appendChild(recipientId);
    messages.appendChild(text);
}
