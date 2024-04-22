# DiscordPalette - Palette for BeepBeep

## Documentation

Here the official link of [DiscordPalette documentation](https://awesomeluffy.github.io/DiscordPaletteDocumentation/introduction.html).

## What is DiscordPalette ?

DiscordPalette is a Palette for [BeepBeep](https://liflab.github.io/beepbeep-3/). In a simple way it's a plugin.

DiscordPalette will allow you to add to your project a way to interact with Discord API and BeepBeep. For example read the message that are sent in a channel, send a message, etc.

## Libraries used

There are 2 main library used in the project
- First [BeepBeep](https://liflab.github.io/beepbeep-3/), the core
- [JDA](https://jda.wiki/introduction/jda/) (Java Discord API) that allow to create and code [Discord](https://discord.com/) bot in Java

## Examples

### Read a message

You can see more examples in the [documentation](https://awesomeluffy.github.io/DiscordPaletteDocumentation/introduction.html)

![DiscordPalette_ReadMessage](https://github.com/AwesomeLuffy/DiscordPalette/assets/56047226/f1d92d5f-575b-41b6-83ff-6eed1fb0e28f)

See the full code in details in [ReadMessage.java](https://github.com/AwesomeLuffy/DiscordPalette/tree/master/src/main/java/ca/uqac/lif/cep/discordpalette/examples/ReadMessage.java)

```java
    public static void main(String[] args) {
        // The token is the key to connect to the Discord API
        String token = "YOUR_TOKEN_HERE";

        // Create a new JDA object (it's the instance of our bot)
        JDA discordBot = JDABuilder.createDefault(token)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();

        // Create a new DiscordPalette object to interact with BeepBeep
        DiscordPalette palette = DiscordPalette.getInstance(discordBot);

        // Then get the processor to read messages
        Processor reader = palette.getDiscordMessageReader();

        // We get a function processor to only get the content of the message
        ApplyFunction getMessageContentFunction = new ApplyFunction(Messages.content);

        // Now we simply create a Print processor to show the messages from Discord
        Print print = new Print();

        // Connect the reader to the getMessageContentFunction
        Connector.connect(reader, getMessageContentFunction);

        // Connect the getMessageContentFunction to the print processor
        Connector.connect(getMessageContentFunction, print);
    }
```
