import React, {Component} from "react";
import "../Styles/SiteHead.css"

class Clock extends Component{
    constructor(props) {
        super(props);
        this.state = {
            date: new Date()
        };
        this.tick = this.tick.bind(this);

    }
    componentDidMount() {
        this.timerID = setInterval(
            () => this.tick(),
            1000
        );
    }
    componentWillUnmount() {
        clearInterval(this.timerID);
    }
    tick() {
        this.setState({
            date: new Date()
        });
    }
    render() {
        return (
        <div className="Time">
            {this.state.date.toLocaleTimeString()} Uhr
        </div>
    )}
}
export default Clock