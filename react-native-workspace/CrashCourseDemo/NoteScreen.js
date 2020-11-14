import React, { Component } from "react";
import { View, TextInput } from "react-native";
import NewButtonDisplay from "./NewButtonDisplay";

//class component
class NoteScreen extends Component {
    //this initializes the state
    state = {
        notes: ""
    }

    handleNotesChange = (notes) => { //this is a function
        this.setState({ //use setState outside of the constructor
            notes: notes
        });
    }

    handleNewButton = () => {
        this.setState({
            notes: ""
        });
    }

    render() {
        const { notes } = this.state;
        return (
            <View>
                <TextInput
                    value = {notes}
                    onChangeText = {this.handleNotesChange}
                    placeholder = {"Write your notes here"}
                />
                <NewButtonDisplay
                    onPress = {this.handleNewButton}
                /> 
            </View>
        )
        //specifies props and names to pass to child components
    }
}

export default NoteScreen;