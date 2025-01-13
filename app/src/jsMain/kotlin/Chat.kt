import csstype.*
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.InputType
import react.dom.html.ReactHTML.aside
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h1
import react.dom.html.ReactHTML.header
import react.dom.html.ReactHTML.input
import react.dom.html.ReactHTML.label
import react.dom.html.ReactHTML.nav

external interface ChatProps : Props {
    var header: String
    var messages: Array<Message>
    var contacts: Array<Contact>
}

data class Message(
    val id: Int,
    val sender: String,
    val text: String
)

data class Contact(
    val name: String,
    val status: String
)

val Chat = FC<ChatProps> { props ->
    console.log(props)
    div {
        css {
            fontFamily = FontFamily.monospace
            backgroundColor = NamedColor.white
            border = Border(2.px, LineStyle.solid, Color("black"))
            width = 100.pct
            maxWidth = 80.ch
            margin = Margin(0.px, Auto.auto)
        }

        header {
            css {
                borderBottom = Border(2.px, LineStyle.solid, Color("black"))
                padding = 0.5.rem
                textAlign = TextAlign.center
                position = Position.relative
            }
            h1 {
                css {
                    fontSize = 1.25.rem
                    fontWeight = FontWeight.bold
                }
                +props.header
            }
        }

        nav {
            css {
                backgroundColor = Color("#e5e5e5")
                padding = Padding(0.5.rem, 1.rem)
                display = Display.flex
                alignItems = AlignItems.center
                borderBottom = Border(2.px, LineStyle.solid, Color("black"))
            }

            button {
                css {
                    marginRight = 1.rem
                }
                +"✶"
            }

            div {
                css {
                    display = Display.flex
                    gap = 1.rem
                }
                button { +"FILE" }
                button { +"EDIT" }
                button { +"VIEW" }
            }

            div {
                css {
                    flexGrow = number(1.0)
                }
            }

            button { +"HELP" }
        }

        div {
            css {
                display = Display.flex
            }

            // Sidebar
            aside {
                css {
                    width = 28.ch
                    borderRight = Border(2.px, LineStyle.solid, Color("black"))
                    padding = 0.5.rem
                }

                props.contacts.forEach { contact ->
                    div {
                        css {
                            marginBottom = 1.rem
                            display = Display.flex
                            alignItems = AlignItems.flexStart
                            gap = 0.5.rem
                        }

                        div {
                            css {
                                width = 1.5.rem
                                height = 1.5.rem
                                backgroundColor = Color("#d1d1d1")
                            }
                        }

                        div {
                            div {
                                css {
                                    fontWeight = FontWeight.bold
                                }
                                +contact.name
                            }
                            div {
                                css {
                                    color = Color("#666")
                                    fontSize = 0.875.rem
                                    overflow = Overflow.hidden
                                    textOverflow = TextOverflow.ellipsis
                                    whiteSpace = WhiteSpace.nowrap
                                    maxWidth = 20.ch
                                }
                                +contact.status
                            }
                        }
                    }
                }
            }

            // Chat area
            div {
                css {
                    flexGrow = number(1.0)
                    padding = 1.rem
                }

                div {
                    css {
                        marginBottom = 1.rem
                    }

                    props.messages.forEach { msg ->
                        div {
                            css {
                                display = Display.flex
                                justifyContent = if (msg.sender == "user") JustifyContent.flexEnd else JustifyContent.flexStart
                                marginBottom = 0.5.rem
                            }

                            div {
                                css {
                                    maxWidth = 40.ch
                                    padding = 0.5.rem
                                    borderRadius = 4.px
                                    whiteSpace = WhiteSpace.preWrap
                                    wordWrap = WordWrap.breakWord
                                    overflowWrap = OverflowWrap.breakWord
                                    backgroundColor = if (msg.sender == "user") Color("#e5e5e5") else Color("#90EE90")
                                }
                                +msg.text
                            }
                        }
                    }
                }

                // Input area
                div {
                    css {
                        marginTop = 2.rem
                    }

                    label {
                        css {
                            display = Display.block
                            color = Color("#444")
                            marginBottom = 0.5.rem
                        }
                        +"Message"
                    }

                    input {
                        css {
                            width = 100.pct
                            padding = Padding(0.5.rem, 0.rem)
                            border = Border(2.px, LineStyle.solid, Color("#d1d1d1"))
                            backgroundColor = Color("#f5f5f5")
                            fontFamily = FontFamily.monospace
                        }
                        placeholder = ""
                        type = InputType.text
                    }
                }
            }
        }
    }
}
