## Developers: [Hannes Dorfmann][0], [Emil Sjölander][1]

#### Sockeqwe Libraries: [FragmentArgs][2], [AnnotatetdAdapter][3], [ParcelablePlease][4], [AdapterDelegates][5]

#### Emilsjolander Libraries: [IntentBuilder][6]

FragmentArgs: Annotation Processor for setting arguments in android fragments
```java

```

AnnotatetdAdapter: Annotation processor for generating RecyclerView and AbsListView adapters

```java
@Arg
String title;

@Arg(required = false)
int id;

FragmentArgs.inject(this);

@FragmentArgsInherited
public class Frag01 extend Frag00

```

ParcelablePlease: Annotation Processor for generating Parcelable code
```java

```

AdapterDelegates: "Favor composition over inheritance" for RecyclerView Adapters
```java

```

IntentBuilder: Type safe intent building for services and activities
'''java

```


[0]: https://github.com/sockeqwe
[1]: https://github.com/emilsjolander

[2]: https://github.com/sockeqwe/fragmentArgs
[3]: https://github.com/sockeqwe/annotatedAdapter
[4]: https://github.com/sockeqwe/parcelablePlease
[5]: https://github.com/sockeqwe/adapterDelegates

[6]: https://github.com/emilsjolander/IntentBuilder
