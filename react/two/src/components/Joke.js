export default class Joke extends React.Component {
  render() {
    return (
      [
        <p className="joke">{this.props.prompt}</p>,
        <p className="joke spoiler">{this.props.body && this.props.body}</p>
      ]
    );
  }
}