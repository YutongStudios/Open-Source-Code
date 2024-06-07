def chatbot():
  responses = {
    "hello": "Hello!",
    "hi": "Hi!",
    "how are you": "I'm good, thanks for asking.",
    "what's your name": "I am a chatbot. What's your name?",
    "my name is": "Nice to meet you, {name}!",
    "goodbye": "Goodbye! It was nice talking to you."
  }

  while True:
    user_input = input("Enter a message: ")
    user_input = user_input.lower()

    if user_input in responses:
      response = responses[user_input]
      print(response)
    elif "name is" in user_input:
      name = user_input.split("name is")[1].strip()
      response = responses["my name is"].format(name=name)
      print(response)
    else:
      print("I'm sorry, I don't understand what you're saying.")

chatbot()
